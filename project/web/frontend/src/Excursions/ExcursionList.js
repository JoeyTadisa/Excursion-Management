import React, { useState } from "react";
import ExcursionsList from "./ExcursionsList";
import ExcursionFilter from "./ExcursionFilter";
import "./ExcursionList.css";
import Card from "../UI/Card";

const ExcursionList = (props) => {
  const [filteredYear, setFilteredYear] = useState("2021");

  const filterChangeHandler = (selectedYear) => {
    setFilteredYear(selectedYear);
  };

  // new array will be returned (filtered year), original is not touched
  // filter method that filteres the array
  const filteredExcursions = props.items.filter((excursion) => {
    // excursion_date is a date object, not a string (initial state of the filteredYear is a string)
    // need to convert to string object

    return (
      excursion.date_of_excursion.getFullYear().toString() === filteredYear
    );
  });

  return (
    <div>
      <Card className="excursion-list">
        <ExcursionFilter
          selected={filteredYear}
          onChangeFilter={filterChangeHandler}
        />
        <ExcursionsList items={filteredExcursions} />
      </Card>
    </div>
  );
};

export default ExcursionList;
