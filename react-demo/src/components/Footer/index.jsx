import React, { Component } from 'react'
import PropTypes from 'prop-types'
import './index.css'

export default class Footer extends Component {

    static propTypes = {
        todoList: PropTypes.array.isRequired,
        updateAllTodo: PropTypes.func.isRequired,
        clearAllDone: PropTypes.func.isRequired
    }

    // 更改全部状态
    handleCheckAll = (event) => {
        this.props.updateAllTodo(event.target.checked)
    }

    // 清除全部任务
    handleClealAllDone = () => {
        this.props.clearAllDone()
    }

    render() {
        const { todoList } = this.props
        // 已完成数量
        const doneCount = todoList.reduce((pre, todo) => pre + (todo.done ? 1 : 0), 0)
        // 总数
        const total = todoList.length
        return (
            <div className='todo-footer'>
                <label>
                    <input type="checkbox" checked={doneCount === total && total !== 0} onChange={this.handleCheckAll} />
                </label>
                <span>
                    <span>已完成{doneCount}</span>/全部{total}
                </span>
                <button className='btn btn-danger' onClick={this.handleClealAllDone}>清除已完成任务</button>
            </div>
        )
    }
}
