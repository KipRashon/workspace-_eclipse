import React from 'react';
import RoomFilter from './RoomFilter';
import RoomList from './RoomList';
// import {RoomConsumer} from '../Context';
import {withRoomConsumer} from '../Context';
import Loading from './Loading';

function RoomContainer({context}){
    const {loading,sortedRooms,rooms} = context;
    if(loading){
        return <Loading/>
     }
    return (
    <>
    <RoomFilter rooms={rooms}/>
    <RoomList rooms={sortedRooms}/>
    </>
    )
}
export default withRoomConsumer(RoomContainer);

// export default function RoomsContainer() {
//     return (
//         <RoomConsumer>
//             {
//                 (value)=>{
//                     const {loading,sortedRooms,rooms} = value;
//                     if(loading){
//                         return <Loading/>
//                     }
//                   return (
//                     <div>
//                     <RoomFilter rooms={rooms}/>3
//                     <RoomList rooms={sortedRooms}/>
//                     </div>
//                   )
//                 }
//             }
//         </RoomConsumer>
        
//     )
// }
