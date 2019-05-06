import React,{Component} from 'react';
import {HashRouter,Route,Switch} from 'react-router-dom';
import Login from "../component/login/Login";
import Main from "../component/main/Main";

class Router extends Component{
    render() {
        return (
            <div>
                <HashRouter>
                    <Switch>
                        <Route path="/login" component={Login}/>
                        <Route path="/main" component={Main}/>
                    </Switch>
                </HashRouter>
            </div>
        );
    }
}
export default Router;