import React, { Component } from 'react'
import PropTypes from 'prop-types'
import './index.css'

export default class Item extends Component {

    // 对接收的参数进行限制
    static propTypes = {
        updateTodo: PropTypes.func.isRequired,
        deleteTodo: PropTypes.func.isRequired
    }

    state = { mouse: false }

    // 鼠标聚焦、离开事件的回调
    handleMouse = (flag) => {
        return () => {
            this.setState({ mouse: flag })
        }
    }

    // 复选框状态改变事件的回调
    handleChangle = (id) => {
        return (event) => {
            this.props.updateTodo(id, event.target.checked)
        }
    }

    // 删除
    handleDelete = (id) => {
        return () => {
            if (window.confirm("确定删除吗？")) {
                this.props.deleteTodo(id)
            }
        }
    }

    render() {
        const { id, name, done } = this.props
        return (
            <li onMouseEnter={this.handleMouse(true)} onMouseLeave={this.handleMouse(false)} style={{ backgroundColor: this.state.mouse ? '#ddd' : 'white' }}>
                <label>
                    <input type="checkbox" checked={done} onChange={this.handleChangle(id)} />
                    <span>{name}</span>
                </label>
                <button className='btn btn-danger' onClick={this.handleDelete(id)} style={{ display: this.state.mouse ? 'block' : 'none' }}>删除</button>
            </li >
        )
    }
}
