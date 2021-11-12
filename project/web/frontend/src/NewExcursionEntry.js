import React from "react";
import ExcursionForm from "./ExcursionForm";

function newExcursionEntry(props) {
  const saveExcursionDataHandler = (enteredExcursionData) => {
    const excursionData = {
      ...enteredExcursionData,
      id: Math.Random().toString(),
    };
    props.onAddExcursion(excursionData);
  };

  return (
    <div>
      <ExcursionForm onSaveExcursionData={saveExcursionDataHandler} />
    </div>
  );
}

export default newExcursionEntry;
