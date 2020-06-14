import React from 'react';
import RoomsFilter from './RoomsFilter';
import RoomList from './RoomList';

export default function RoomsContainer() {
    return (
        <div>
            Hello from rooms container
            <RoomsFilter/>
            <RoomList/>
        </div>
    )
}
