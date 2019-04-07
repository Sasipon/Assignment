import React, { Component } from 'react'
import PostData from '../data/payment.json'
import  '../css/Style.css'

class Table extends Component {
  render() {
    return ( <center>
              <table id="customers">
                <thead>
                <tr>
                  <th>Mobile number</th>
                  <th>Payment amount (Baht)</th>
                </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                      {PostData.map((postDetail, index)=>{
                      return <center><p>{postDetail.tel}</p></center>})}
                    </td>
                    <td>
                      {PostData.map((postDetail, index)=>{
                        return <center><p>{postDetail.total}</p></center>})}
                    </td>
                  </tr>
                </tbody>
              </table>
            </center>
    )}
  }

export default Table;
