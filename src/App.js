import React from 'react';
import {Switch,Route} from 'react-router-dom';
import './App.css';

import Home from './pages/Home';
import Rooms from './pages/Rooms';
import SingleRoom from './pages/SingleRoom';
import Error from './pages/Error';

import NavBar from './components/Navbar';

function App() {
   
    return ( 
        <React.Fragment>
            <NavBar/>
            <Switch>
            <Route exact path='/' component={Home}/>
            <Route exact path='/rooms' component={Rooms}/>
            <Route exact path='/rooms/:roomname' component={SingleRoom}/>
            <Route component={Error}/>
            </Switch>
        </React.Fragment>
    )
    }

    export default App;