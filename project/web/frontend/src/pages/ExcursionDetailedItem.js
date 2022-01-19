import React from "react";
import "./ExcursionDetailedItem.css";
import Card from "../components/UI/Card";
import ExcursionDate from "../components/Excursions/ExcursionDate";
import UserStore from "../components/stores/UserStore";
import { useLocation, useHistory } from "react-router-dom";

/**
 * The detailed view of an excursion for an admin to view, accept or reject a new excursion
 * @component
 */
const ExcursionDetailedItem = () => {
  const location = useLocation();
  const history = useHistory();
  const state = location.state;
  /**
   * passing the approval status for the button
   * that will be shown only to the admin
   */
  const buttonOkToShow = state.approval_status;

  if (!state) {
    return <p>No excursion found!</p>;
  }
  /**
   * formating the reviewed date to send to backend
   * @property {Function} approveExcursionAndCloseView
   * @returns {void}
   */
  const approveExcursionAndCloseView = () => {
    let dateReviewed = new Date();
    const date_reviewed = Date.parse(
      dateReviewed.getFullYear() +
        "-" +
        (dateReviewed.getMonth() + 1) +
        "-" +
        dateReviewed.getDate()
    );

    const dataForExcursionApproval = {
      id: state.id,
      approval_status: "a",
      date_reviewed: date_reviewed,
      reviewed_by: UserStore.user_no,
    };

    changeToApprovedExcursion(dataForExcursionApproval);

    // data for excursion a aspproval sent to backend
    /**
     * @param {Object} dataForExcursionApproval
     */
    async function changeToApprovedExcursion(dataForExcursionApproval) {
      const response = await fetch(
        "http://localhost:9191/api/excursion/approve",
        {
          method: "PUT",
          body: JSON.stringify(dataForExcursionApproval),
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      if (!response.ok) {
        throw new Error("Could not approve the excursion.");
      }
      if (response.ok) {
        alert("✨ The excursion was approved ✨");
      }
      //const data = await response.json();
      onCloseView();
    }
  };
  /**
   * formating the reviewed date to send to backend
   * @property {Function} approveExcursionAndCloseView
   * @returns {void}
   */
  const rejectExcursionAndCloseView = () => {
    let dateReviewed = new Date();
    const date_reviewed = Date.parse(
      dateReviewed.getFullYear() +
        "-" +
        (dateReviewed.getMonth() + 1) +
        "-" +
        dateReviewed.getDate()
    );

    const dataForExcursionDisapproval = {
      id: state.id,
      approval_status: "d",
      date_reviewed: date_reviewed,
      reviewed_by: UserStore.user_no,
    };

    changeToDisapprovedExcursion(dataForExcursionDisapproval);
    /**
     * data for excursion a aspproval sent to backend
     * @param {Object} dataForExcursionDisapproval
     */
    async function changeToDisapprovedExcursion(dataForExcursionDisapproval) {
      const response = await fetch(
        "http://localhost:9191/api/excursion/disapprove",
        {
          method: "PUT",
          body: JSON.stringify(dataForExcursionDisapproval),
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      if (!response.ok) {
        throw new Error("Could not disapprove the excursion.");
      }
      if (response.ok) {
        alert("✨ The excursion was disapproved ✨");
      }
      //const data = await response.json();
      onCloseView();
    }
  };
  /**
   * closing the view and back to excursion lists
   * @property {Function} onCloseView
   * @returns {void}
   */
  const onCloseView = () => {
    history.goBack();
  };

  return (
    <li>
      <div className="excursion-detailed-item-frame">
        <Card className="excursion-detailed-item">
          <h4>Excursion date</h4>
          <ExcursionDate date={new Date(state.date_of_excursion)} />
          <div className="excursion-detailed-item__title">
            <h4>Destination</h4>
            <h2>{state.title}</h2>
          </div>
          <div className="excursion-detailed-item__description">
            <h4>Description</h4>
            <h2>{state.description}</h2>
          </div>
          <div className="max-num-participants-and-fee">
            <div className="max-num-participants">
              <h4>Maximum number </h4>
              <h4>of participants </h4>
              <h2>{state.max_participants}</h2>
            </div>
            <div className="excursion-fee">
              <h4>Excursion </h4>
              <h4>fee </h4>
              <h2>{state.excursion_fee}</h2>
            </div>
          </div>
          <div className="reg-and-dereg-dealines">
            <div className="reg-deadline">
              <h4>Registration</h4>
              <h4>deadline</h4>
              <ExcursionDate date={new Date(state.reg_deadline)} />
            </div>
            <div className="dereg-deadline">
              <div className="dereg-deadline-title-only">
                <h4>Deregistration</h4>
                <h4>deadline</h4>
              </div>
              <div className="dereg-deadline-calender-only">
                <ExcursionDate date={new Date(state.dereg_deadline)} />
              </div>
            </div>
          </div>
          <div>
            <h4>Meeting point details</h4>
            <h2>{state.meeting_details}</h2>
          </div>
          <div className="footer">
            {/* only if admin, reject button is shown at the end of detailed view 
              to reject & close details */}
            {buttonOkToShow === "p" && UserStore.user_type === "ROLE_a" && (
              <button className="reject" onClick={rejectExcursionAndCloseView}>
                Reject
              </button>
            )}
            {/* only if admin and excursion has a pending status, approve button is shown 
            at the end of detailed view to approve & close details 
                */}
            {buttonOkToShow === "p" && UserStore.user_type === "ROLE_a" && (
              <button
                className="approve"
                onClick={approveExcursionAndCloseView}
              >
                Approve
              </button>
            )}
            {/**
             * if it is approved excursion, close button is shown at the end
             * of detailed view to close details for admin
             */}
            {buttonOkToShow === "a" && (
              <button className="close" onClick={onCloseView}>
                Close
              </button>
            )}
          </div>
        </Card>
      </div>
    </li>
  );
};

export default ExcursionDetailedItem;
