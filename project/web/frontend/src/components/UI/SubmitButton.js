import React from "react";
import "./SubmitButton.css";
/**
 * @component SubmitButton could be used with any form
 */
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
