import React, { useState } from "react";
import ExcursionItem from "./ExcursionItem";
import ExcursionFilter from "./ExcursionFilter";
import "./ExcursionList.css";
import Card from "../UI/Card";

const ExcursionList = (props) => {
  const [filteredYear, setFilteredYear] = useState("2021");

  const filterChangeHandler = (selectedYear) => {
    setFilteredYear(selectedYear);
  };
  // new array will be returned (filtered year), original is not touched
  const filteredExcursions = props.excursions.filter((excursion) => {
    console.log(excursion.excursion_date.getFullYear().toString());
    return excursion.excursion_date.getFullYear().toString() === filteredYear;
  });

  // if no excursions in the filtered year, a msg displayed
  let excursionsContent = <p>No excursions found.</p>;

  // if there are items in the filtered year, display all excursions
  if (filteredExcursions.length > 0) {
    excursionsContent = filteredExcursions.map((excursion) => (
      <ExcursionItem
        key={excursion.id}
        title={excursion.title}
        date={excursion.excursion_date}
      />
    ));
  }

  return (
    <div>
      <Card className="excursion-list">
        <ExcursionFilter
          selected={filteredYear}
          onChangeFilter={filterChangeHandler}
        />
        {excursionsContent}
      </Card>
    </div>
  );
};

export default ExcursionList;
