import React from "react";
import "./ExcursionDetailedItem.css";
import Card from "../UI/Card";
import ExcursionDate from "./ExcursionDate";

const ExcursionDetailedItem = (props) => {
  return (
    <li>
      <Card className="excursion-detailed-item">
        <h4>Excursion date</h4>
        <ExcursionDate date={props.date_of_excursion} />
        <div className="excursion-detailed-item__title">
          <h4>Destination</h4>
          <h2>{props.title}</h2>
        </div>
        <div className="excursion-detailed-item__description">
          <h4>Description</h4>
          <h2>{props.description}</h2>
        </div>
        <div className="max-num-participants-and-fee">
          <div className="max-num-participants">
            <h4>Maximum number </h4>
            <h4>of participants </h4>
            <h2>{props.max_participants}</h2>
          </div>
          <div className="excursion-fee">
            <h4>Excursion </h4>
            <h4>fee </h4>
            <h2>{props.excursion_fee}</h2>
          </div>
        </div>
        <div className="reg-and-dereg-dealines">
          <div className="reg-deadline">
            <h4>Registration</h4>
            <h4>deadline</h4>
            <ExcursionDate date={props.reg_deadline} />
          </div>
          <div className="dereg-deadline">
            <div className="dereg-deadline-title-only">
              <h4>Deregistration</h4>
              <h4>deadline</h4>
            </div>
            <div className="dereg-deadline-calender-only">
              <ExcursionDate date={props.dereg_deadline} />
            </div>
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
