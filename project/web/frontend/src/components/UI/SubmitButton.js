import React from "react";
import "./SubmitButton.css";

class SubmitButton extends React.Component {
  render() {
    return (
      <div className="submitButton">
        <button
          className="btn"
          disabled={this.props.disabled}
          onClick={() => this.props.onClick()}
          onSubmit={() => this.props.onSubmit()}
        >
          {this.props.text}
        </button>
      </div>
    );
  }
}

export default SubmitButton;
