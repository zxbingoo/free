import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, hashHistory, IndexRoute } from 'react-router';
import Login from "../component/login/Login";
import Main from "../component/main/Main";

ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/" component={Login}>
            <IndexRoute component={Login} />
            <Route path="/main" component={Main} />
        </Route>
    </Router>,
    document.getElementById('app'));

/* 另外一種寫法：
  const routes = (
      <Route path="/" component={App}>
        <IndexRoute component={Home} />
        <Route path="/repos/:name" component={Repos} />
        <Route path="/about" component={About} />
        <Route path="/user" component={User} />
        <Route path="/contacts" component={Contacts} />
      </Route>
  );

  ReactDOM.render(
    <Router routes={routes} history={hashHistory} />,
    document.getElementById('app'));
*/