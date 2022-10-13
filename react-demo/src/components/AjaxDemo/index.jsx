import React, { Component } from 'react'
import axios from 'axios'

export default class AjaxDemo extends Component {

  /**
   * 获取用户信息
   */
  getUser = () => {
    axios.get("http://localhost:3000/api/user",).then(
      response => {
        console.log("获取用户信息成功：", response.data);
      },
      error => {
        console.error("获取用户信息失败：", error);
      }
    )
  }

  render() {
    return (
      <div>
        <span>3、AjaxDemo</span><br />
        <button onClick={this.getUser}>获取用户信息</button>
        <span>&nbsp;通过控制台查看获取的用户信息</span>
      </div>
    )
  }
}
