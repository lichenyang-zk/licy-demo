import React, { Component } from 'react'
import Search from './Search'
import List from './List'

export default class GithubSearchNew extends Component {

    render() {
        return (
            <div>
                <Search />
                <List />
            </div>
        )
    }
}
