import React, { Component } from 'react'
import logo from './logo.svg'
import Header from './components/Header'
import Table from './components/Table'
import './css/App.css'

class App extends Component {
  render() {
    return (
      <div className='App'>
        <Header />
        <h1>PAYMENT</h1>
        <Table />
      </div>
    );
  }
}

export default App;
