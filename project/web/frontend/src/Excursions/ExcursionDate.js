import React from "react";
import "./ExcursionDate.css";

const ExcursionDate = (props) => {
  const month = props.excursion_date.toLocaleString("en-US", {
    month: "long",
  });
  const day = props.excursion_date.toLocaleString("en-US", {
    day: "2-digit",
  });
  const year = props.excursion_date.getFullYear().toString();

  return (
    <div className="excursion-date">
      <div className="excursion-date__year">{year}</div>
      <div className="excursion-date__month">{month}</div>
      <div className="excursion-date__day">{day}</div>
    </div>
  );
};

export default ExcursionDate;
