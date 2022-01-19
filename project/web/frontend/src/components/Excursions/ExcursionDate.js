import React from "react";
import "./ExcursionDate.css";
/**
 * @component ExcursionDate formating the passed in date
 * @param {Object} props date object fetched from backend and passed to format
 * @returns {void}
 */
const ExcursionDate = (props) => {
  const month = props.date.toLocaleString("en-US", {
    month: "2-digit",
  });
  const day = props.date.toLocaleString("en-US", {
    day: "2-digit",
  });
  const year = props.date.getFullYear().toString();

  return (
    <div className="excursion-date">
      <div className="excursion-date__year">{year}</div>
      <div className="excursion-date__month">{month}</div>
      <div className="excursion-date__day">{day}</div>
    </div>
  );
};

export default ExcursionDate;
