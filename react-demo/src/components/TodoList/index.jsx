import React, { Component } from 'react'
import Header from './Header'
import List from './List'
import Footer from './Footer'
import './index.css';

// 65集过半

export default class TodoList extends Component {
    state = {
        todoList: [
            { id: "01", name: "吃饭", done: false },
            { id: "02", name: "睡觉", done: true },
            { id: "03", name: "玩游戏", done: false }
        ]
    }

    // 添加一个TODO
    addTodo = (todoObj) => {
        // 获取原来的todoList
        const { todoList } = this.state
        // 封装一个新的todoList
        const newTodoList = [todoObj, ...todoList]
        // 更新状态
        this.setState({ todoList: newTodoList })
    }

    // 更新一个TODO
    updateTodo = (id, done) => {
        const { todoList } = this.state
        const newTodoList = todoList.map((todoObj) => {
            if (todoObj.id === id) {
                return { ...todoObj, done }
            } else {
                return todoObj
            }
        })
        // 更新状态
        this.setState({ todoList: newTodoList })
    }

    // 更新所有TODO
    updateAllTodo = (done) => {
        const { todoList } = this.state
        const newTodoList = todoList.map((todoObj) => {
            return { ...todoObj, done }
        })
        // 更新状态
        this.setState({ todoList: newTodoList })
    }

    // 删除一个TODO
    deleteTodo = (id) => {
        const { todoList } = this.state
        const newTodoList = todoList.filter((todoObj) => {
            return todoObj.id !== id
        })
        // 更新状态
        this.setState({ todoList: newTodoList })
    }

    // 清除所有已完成任务
    clearAllDone = () => {
        const { todoList } = this.state
        const newTodoList = todoList.filter((todoObj) => {
            return !todoObj.done
        })
        // 更新状态
        this.setState({ todoList: newTodoList })
    }

    render() {
        const { todoList } = this.state
        return (
            <div className="todo-container">
                <span>TodoList</span>
                <div className='todo-warp'>
                    <Header addTodo={this.addTodo} />
                    <List todoList={todoList} updateTodo={this.updateTodo} deleteTodo={this.deleteTodo} />
                    <Footer todoList={todoList} updateAllTodo={this.updateAllTodo} clearAllDone={this.clearAllDone} />
                </div>
            </div>
        )
    }
}
