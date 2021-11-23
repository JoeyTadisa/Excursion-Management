import React from "react";
import "./ExcursionDetailedItem.css";
import Card from "../UI/Card";
import ExcursionDate from "./ExcursionDate";

const ExcursionDetailedItem = (props) => {
  return (
    <li className="excursion-detailed-item">
      <Card className="excursion-detailed-item">
        {/* <label>Excursion date</label>
        <ExcursionDate date={props.excursion_date} /> */}
        <div className="excursion-detailed-item__title">
          <h4>Destination</h4>
          <h2>{props.title}</h2>
        </div>
        <div>
          <h4>Description</h4>
          <h2>{props.description}</h2>
        </div>
        <div className="max-num-participants">
          <h4>Maximum number of participants</h4>
          <h2>{props.max_participants}</h2>
        </div>
        <div className="reg-and-dereg-dealines">
          <div className="reg-deadline">
            <h4>Registration</h4>
            <h4>deadline</h4>
            <ExcursionDate date={props.reg_deadline} />
          </div>
          <div className="dereg-deadline">
            <h4>Deregistration</h4>
            <h4>deadline</h4>
            <ExcursionDate date={props.dereg_deadline} />
          </div>
        </div>
        <div>
          <h4>Meeting point details</h4>
          <h2>{props.meeting_details}</h2>
        </div>
      </Card>
    </li>
  );
};

export default ExcursionDetailedItem;
