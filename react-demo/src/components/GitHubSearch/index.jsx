import React, { Component } from 'react'
import Search from './Search'
import List from './List'

export default class GithubSearch extends Component {

    state = {
        users: [], // 用户数据初始化
        isFirst: true, // 是否处于第一次打开
        isLoading: false, // 是否处于加载中
        errMsg: '' //错误信息
    }

    // 更新app的state
    updateAppState = (stateObj) => {
        this.setState(stateObj)
    }

    render() {
        return (
            <div>
                <Search updateAppState={this.updateAppState} />
                <List {...this.state} />
            </div>
        )
    }
}
