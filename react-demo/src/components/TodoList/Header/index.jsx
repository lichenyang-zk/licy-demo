import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { nanoid } from 'nanoid';
import './index.css'

export default class Header extends Component {

    // 对接收的参数进行限制
    static propTypes = {
        addTodo: PropTypes.func.isRequired
    }

    // 键盘事件的回调
    handleKeyUp = (event) => {
        const { keyCode, target } = event
        // 13代表回车键
        if (keyCode !== 13) {
            return
        }
        if (target.value.trim() === "") {
            alert("请输入内容后，再按回车键")
            return
        }
        const todoObj = {
            id: nanoid(),
            name: target.value,
            done: false
        }
        // 传值给父组件
        this.props.addTodo(todoObj)
        // 清除输入框
        target.value = ""
    }

    render() {
        return (
            <div className='todo-header'>
                <input onKeyUp={this.handleKeyUp} type="text" placeholder="请输入你的任务名称，按回车键确认" />
            </div>
        )
    }
}
