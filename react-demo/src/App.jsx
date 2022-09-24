import React, { Component } from 'react'
import Hello from './components/Hello';
import TodoList from './components/TodoList';
import AjaxDemo from './components/AjaxDemo';
import './App.css';

// 65集过半

export default class App extends Component {

  render() {
    return (
      <div>
        <Hello />
        <hr className='hr'/>
        <span>TodoList</span>
        <TodoList />
        <hr className='hr' />
        <AjaxDemo />
        <hr className='hr' />
      </div>
    )
  }
}
