import React, { Component } from 'react';
import items from './data';

const RoomContext = React.createContext();

export default class RoomProvider extends Component {
    state= {
        rooms:[],
        sortedRooms:[],
        featuredRooms:[],
        loading:true
    };

    //get external data 
    componentDidMount(){
        let rooms = this.formartData(items);
        let featuredRooms = rooms.filter(room=>room.featured === true);
        this.setState({
            rooms,featuredRooms,sortedRooms:rooms,loading:false
        });
    }

    formartData(itemsToFormat){
        let tempItems = itemsToFormat.map(item=>{
            let id = item.sys.id;
            let images = item.fields.images.map(image=> image.fields.file.url);
            let room = {...item.fields, images,id};
            return room;
        });

        return tempItems;
    }

    getRoom = (slug) =>{
        let tempRooms = [...this.state.rooms];
        const room = tempRooms.find(tempRoom => tempRoom.slug===slug);
        return room;
    }
    render() {
        return (
             <RoomContext.Provider value={{...this.state,getRoom:this.getRoom}}>
                 {this.props.children}
             </RoomContext.Provider>
        )
    }
}


//creatoing the consumer to access the data 
const RoomConsumer = RoomContext.Consumer;

//higher order component
export function withRoomConsumer(Component){
    return function ConsumerWrapper(props){
        return <RoomConsumer>
            {
                value=><Component {...props} context= {value}/>
            }
        </RoomConsumer>
    }
}

export {RoomProvider,RoomConsumer,RoomContext};