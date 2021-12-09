import React from "react";
import "./ExcursionDetailedItem.css";
import Card from "../UI/Card";
import ExcursionDate from "./ExcursionDate";
import UserStore from "../stores/UserStore";

const ExcursionDetailedItem = (props) => {
  const buttonOkToShow = props.item.is_approved;

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
      id: props.item.id,
      is_approved: true,
      date_reviewed: date_reviewed,
      reviewed_by: UserStore.user_no,
    };

    changeToApprovedExcursion(dataForExcursionApproval);

    // data for excursion a aspproval sent to backend
    async function changeToApprovedExcursion(dataForExcursionApproval) {
      const response = await fetch("http://localhost:9191/approveExcursion", {
        method: "PUT",
        body: JSON.stringify(dataForExcursionApproval),
        headers: {
          "Content-Type": "application/json",
        },
      });
      const data = await response.json();

      onCloseView();
      alert("✨The excursion was approved✨");
    }
  };

  const rejectExcursionAndCloseView = () => {};

  const onCloseView = () => {
    if (UserStore.user_type === "a")
      props.setState({ whichComponentToShow: "ExcursionItem" });
    if (UserStore.user_type === "o")
      props.setState({ whichComponentToShow: "ExcursionItem" });
  };

  return (
    <li>
      <Card className="excursion-detailed-item">
        <h4>Excursion date</h4>
        <ExcursionDate date={props.item.date_of_excursion} />
        <div className="excursion-detailed-item__title">
          <h4>Destination</h4>
          <h2>{props.item.title}</h2>
        </div>
        <div className="excursion-detailed-item__description">
          <h4>Description</h4>
          <h2>{props.item.description}</h2>
        </div>
        <div className="max-num-participants-and-fee">
          <div className="max-num-participants">
            <h4>Maximum number </h4>
            <h4>of participants </h4>
            <h2>{props.item.max_participants}</h2>
          </div>
          <div className="excursion-fee">
            <h4>Excursion </h4>
            <h4>fee </h4>
            <h2>{props.item.excursion_fee}</h2>
          </div>
        </div>
        <div className="reg-and-dereg-dealines">
          <div className="reg-deadline">
            <h4>Registration</h4>
            <h4>deadline</h4>
            <ExcursionDate date={props.item.reg_deadline} />
          </div>
          <div className="dereg-deadline">
            <div className="dereg-deadline-title-only">
              <h4>Deregistration</h4>
              <h4>deadline</h4>
            </div>
            <div className="dereg-deadline-calender-only">
              <ExcursionDate date={props.item.dereg_deadline} />
            </div>
          </div>
        </div>
        <div>
          <h4>Meeting point details</h4>
          <h2>{props.item.meeting_details}</h2>
        </div>
        <div className="footer">
          {buttonOkToShow === false && UserStore.user_type === "a" && (
            <button className="reject" onClick={rejectExcursionAndCloseView}>
              Reject
            </button>
          )}
          {/* if admin, approve button is shown at the end of detailed view 
              to approve & close details */}
          {buttonOkToShow === false && UserStore.user_type === "a" && (
            <button className="approve" onClick={approveExcursionAndCloseView}>
              Approve
            </button>
          )}
          {/* if it is approved excursion, close button is shown at the end 
              of detailed view to close details for both admin & organiser */}
          {buttonOkToShow === true && (
            <button className="close" onClick={onCloseView}>
              Close
            </button>
          )}

          {/* if organiser, close button is shown at the end of detailed view to close details */}
          {buttonOkToShow === false && UserStore.user_type === "o" && (
            <button className="close" onClick={onCloseView}>
              Close
            </button>
          )}
        </div>
      </Card>
    </li>
  );
};

export default ExcursionDetailedItem;
