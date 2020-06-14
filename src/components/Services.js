import React, { Component } from 'react';
import {FaCocktail,FaHiking,FaBeer, FaShuttleVan} from 'react-icons/fa';
import Title from './Title';

export default class Services extends Component {
    state={
        services:[
            {
                icon:<FaCocktail/>,
                title:"Free cocktails",
                info:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, minus."
            },
            {
                icon:<FaHiking/>,
                title:"Endless Hiking",
                info:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, minus."
            },
            {
                icon:<FaShuttleVan/>,
                title:"Free Shuttle",
                info:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, minus."
            },
            {
                icon:<FaBeer/>,
                title:"Strongest Beer",
                info:"Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, minus."
            }
        ]
    }
    render() {
        return (
            <section className="services">
                <Title title="Services"/>
                <div className="services-center">
                    {
                        this.state.services.map((item,index)=>{
                            return <article key={index} className="service">
                                <span>{item.icon}</span>
                                <h6>{item.title}</h6>
                                <p>{item.info}</p>
                            </article>
                        })
                    }
                </div>
            </section >
        )
    }
}
