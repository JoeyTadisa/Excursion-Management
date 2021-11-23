import React from "react";

import "./ExcursionFilter.css";

const ExcursionFilter = (props) => {
  const dropDownChangeHandler = (event) => {
    console.log(event.target.value);
    props.onChangeFilter(event.target.value);
  };

  return (
    <div className="excursion-filter">
      <div className="excursion-filter__control">
        <label>Filter by year</label>
        <select value={props.selected} onChange={dropDownChangeHandler}>
          <option value="9999">9999</option>
          <option value="2024">2024</option>
          <option value="2023">2023</option>
          <option value="2022">2022</option>
          <option value="2021">2021</option>
        </select>
      </div>
    </div>
  );
};

export default ExcursionFilter;
