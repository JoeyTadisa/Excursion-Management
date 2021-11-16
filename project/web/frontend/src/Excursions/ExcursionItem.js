import React from "react";
import ExcursionDate from "./ExcursionDate";
import "./ExcursionItem.css";
import Card from "../UI/Card";

const ExcursionItem = (props) => {
  return (
    <li>
      <Card className="excursion-item">
        <ExcursionDate excursion_date={props.date} />
        <div className="excursion-item__title">
          <h2>{props.title}</h2>
        </div>
      </Card>
    </li>
  );
};

export default ExcursionItem;
