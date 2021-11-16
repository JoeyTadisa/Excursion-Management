import React from "react";
import ExcursionDate from "./ExcursionDate";
import "./ExcursionItem.css";
import Card from "../UI/Card";

const ExcursionItem = (props) => {
  return (
    <Card className="excursion-item">
      <ExcursionDate excursion_date={props.date} />
      <div className="expense-item__title">
        <h3>{props.title}</h3>
      </div>
    </Card>
  );
};

export default ExcursionItem;
