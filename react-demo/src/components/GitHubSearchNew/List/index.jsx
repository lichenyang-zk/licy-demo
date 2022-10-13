import React, { Component } from 'react'
import PubSub from 'pubsub-js'
import './index.css'

export default class List extends Component {

    state = {
        users: [], // 用户数据初始化
        isFirst: true, // 是否处于第一次打开
        isLoading: false, // 是否处于加载中
        errMsg: '', // 错误信息
        clearAll: false // 清除所有
    }

    // 初始化信息
    componentDidMount() {
        // 订阅
        this.userToken = PubSub.subscribe('githubUser', (_, stateObj) => {
            this.setState(stateObj)
        })
        this.clearToken = PubSub.subscribe('clearKeyWord', (_, stateObj) => {
            this.setState(stateObj)
        })
    }

    // 即将注销
    componentWillUnmount() {
        // 取消订阅
        PubSub.unsubscribe(this.userToken)
        PubSub.unsubscribe(this.clearToken)
    }

    render() {
        const { users, isFirst, isLoading, errMsg, clearAll } = this.state
        return (
            <div className='row' style={{ height: users.length > 0 ? "375px" : "25px" }}>
                {
                    isFirst ? <span>请输入关键字，点击搜索获取用户信息</span> :
                        isLoading ? <span>用户信息获取中. . . . . .</span> :
                            clearAll ? <span>请输入关键字，点击搜索获取用户信息</span> :
                                errMsg ? <span style={{ color: "red" }}>{errMsg}</span> :
                                    users.map((userObj) => {
                                        return (
                                            <div key={userObj.id} className='card'>
                                                <a rel='noreferrer' href={userObj.html_url} target='_blank'>
                                                    <img alt={userObj.login} src={userObj.avatar_url} style={{ width: "100px" }} />
                                                </a>
                                                <p className='card-text'>{userObj.login}</p>
                                            </div>
                                        )
                                    })
                }
            </div>
        )
    }
}
