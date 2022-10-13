import React, { Component } from 'react'
import PubSub from 'pubsub-js';
import axios from 'axios';

export default class Search extends Component {

    search = () => {
        // 获取用户输入的关键字，结构赋值连续写法
        const {
            keyWordElement: { value: keyWord },
            // props: { updateAppState }
        } = this;
        // 发送请求前，通知List更新状态
        // updateAppState({ isFirst: false, isLoading: true })
        PubSub.publish('githubUser', { isFirst: false, isLoading: true })
        // 发送网络请求，获取用户信息
        axios.get(`https://api.github.com/search/users?q=${keyWord}`).then(
            response => {
                console.log("获取用户信息成功：", response.data);
                // 发送请求成功，通知List更新状态
                // updateAppState({ isLoading: false, users: response.data.items, errMsg: '' })
                PubSub.publish('githubUser', { isLoading: false, users: response.data.items, errMsg: '', clearAll: false })
            },
            error => {
                console.error("获取用户信息失败：", error)
                // 发送请求失败，通知List更新状态
                // updateAppState({ isLoading: false, errMsg: error.message })
                PubSub.publish('githubUser', { isLoading: false, errMsg: error.message, clearAll: false })
            }
        )
    }

    clear = () => {
        const {
            keyWordElement
        } = this
        keyWordElement.value = ''
        PubSub.publish('clearKeyWord', { users: [], clearAll: true })
    }

    render() {
        return (
            <div>
                <span>5、搜索GitHub用户_pubsub-js订阅与发布</span><br />
                <input ref={c => this.keyWordElement = c} type="text" placeholder='请输入关键词' />&nbsp;
                <button onClick={this.search}>搜索</button>&nbsp;
                <button onClick={this.clear}>重置</button>
            </div>
        )
    }
}
