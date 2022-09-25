import React, { Component } from 'react'
import './index.css'

export default class List extends Component {

    render() {
        const { users, isFirst, isLoading, errMsg } = this.props
        return (
            <div className='row' style={{ height: users.length > 0 ? "375px" : "25px" }}>
                {
                    isFirst ? <span>请输入关键字，点击搜索获取用户信息</span> :
                        isLoading ? <span>用户信息获取中. . . . . .</span> :
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
