import React, {Component} from "react";

export class PostData extends Component {
    static displayName = PostData.name;

    constructor(props) {
        super(props);
        this.state = {message: null};
        this.postData = this.postData.bind(this);
    }

    render(){
        return (
            <div>
              <input name="teste"></input>
              <button className="btn btn-primary" onClick={() =>{ this.postData(this.teste) }}>Post</button>
              
              <p>{this.state.message}</p>
              
            </div>
          );
    }

    async postData(val) {
        console.log(val);
        let setResp = this;
        console.log(setResp);
        const response = fetch('weatherforecast', {
          headers: {
            "Content-Type": "application/json",
          },
          method: "POST",
          body: JSON.stringify(val),
        })
        .then(res => res.json())
        .then(res => this.setState(res));
        
      }
}