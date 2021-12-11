import React from "react";
import "./Modal.css";

const Modal = ({ closeModal }) => {
  return (
    <div className="modal-background">
      <div className="modal-container">
        <div className="modal-title-close-btn">
          <button onClick={() => closeModal(false)}> x </button>
          <div className="modal-title">
            <h2>{Title}</h2>
          </div>
          <div className="modal-body">{Body}</div>
          <div className="modal-footer">
            <button className="reject">Reject</button>
            <button className="approve">Approve</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Modal;
