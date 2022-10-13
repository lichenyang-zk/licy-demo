import React, { Component } from 'react'
import Hello from './components/Hello';
import TodoList from './components/TodoList';
import AjaxDemo from './components/AjaxDemo';
import GithubSearch from './components/GitHubSearch';
import GithubSearchNew from './components/GitHubSearchNew';
import './App.css';

// 65集过半

export default class App extends Component {

  render() {
    return (
      <div>
        <GithubSearchNew />
        <hr className='hr' />
        <GithubSearch />
        <hr className='hr' />
        <AjaxDemo />
        <hr className='hr' />
        <TodoList />
        <hr className='hr' />
        <Hello />
        <hr className='hr' />
      </div>
    )
  }
}
