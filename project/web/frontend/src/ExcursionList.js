import React from "react";


class ExcursionList extends React.Component {
  constructor(props) {
    super(props);
    //to avoid double requests to API, initial state is empty for username/password
    this.state = {
      excursiondatalist: props.data,
      getHeader : this.getHeader.bind(this),
      getRowsData : this.getRowsData.bind(this),
      getKeys : this.getKeys.bind(this),
    };
  }

  getKeys = function(){
    return Object.keys(this.excursiondatalist);
  }
  
  /*getHeader = function(){
    var keys = this.getKeys();
    return keys.map((key, index)=>{
    return <th key={key}>{key.toUpperCase()}</th>
    })
  }
  
  getRowsData = function(){
    var items = this.props.data;
    var keys = this.getKeys();
    return items.map((row, index)=>{
    return <tr key={index}><RenderRow key={index} data={row} keys={keys}/></tr>
    })
  } */
  
  render() {
    return (
    <div>
      <table>
        <thead>
          <tr>{this.excursiondatalist
          }</tr>
        </thead>
          <tbody>
            This is a body
          </tbody>
      </table>
    </div>
    
    );
    
    }
}

const RenderRow = (props) =>{
  /*return props.keys.map((key, index)=>{
    return <td key={props.data[key]}>{props.data[key]}</td>
    })*/

    return <h1>sample</h1>
}

export default ExcursionList;
