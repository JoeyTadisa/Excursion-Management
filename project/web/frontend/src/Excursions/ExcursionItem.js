import React, { useState } from "react";
import ExcursionDate from "./ExcursionDate";
import "./ExcursionItem.css";
import Card from "../UI/Card";
import ExcursionDetailedItem from "./ExcursionDetailedItem";
import UserStore from "../stores/UserStore";
import ExcursionFormPopulated from "./ExcursionFormPopulated";

const ExcursionItem = (props) => {
  const [excursionByID, setExcursionByID] = useState();
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const [state, setState] = useState({
    visible: true,
    whichComponentToShow: "ExcursionItem",
  });

  async function fetchDetailedExcursionByID() {
    setIsLoading(true);
    // clear previous error
    setError(null);
    try {
      const response = await fetch(
        `http://localhost:9191/excursion/${props.id}`
      );

      // need to check before parsing the response body
      // signals if the response was successful
      if (!response.ok) {
        throw new Error("Something went wrong!");
      }
      const data = await response.json();

      setExcursionByID({
        id: data.id,
        title: data.title,
        date_of_excursion: new Date(data.date_of_excursion),
        excursion_fee: data.excursion_fee,
        description: data.description,
        max_participants: data.max_participants,
        destination: data.destination,
        reg_deadline: new Date(data.reg_deadline),
        dereg_deadline: new Date(data.dereg_deadline),
        meeting_details: data.meeting_details,
        is_approved: data.is_approved,
      });
      if (UserStore.user_type === "a")
        setState({ whichComponentToShow: "ExcursionDetailedItem" });

      // if (UserStore.user_type === "o")
      //   setState({ whichComponentToShow: "ExcursionFormPopulated" });
    } catch (error) {
      setError(error.message);
    }
    // done loading, no matter if we got successful or an error response
    setIsLoading(false);
  }

  // for better user experience need to display to user
  // if the content is loading/error occured
  let content = <p>The excursion is not found.</p>;
  let content1 = <p>The excursion is not found.</p>;

  if (UserStore.user_type === "a") {
    if (excursionByID !== null) {
      content = <ExcursionDetailedItem item={excursionByID} />;
    }
    if (error) {
      content = <p>{error}</p>;
    }
    if (isLoading) {
      content = <p>Loading...</p>;
    }
  }

  if (UserStore.user_type === "o") {
    if (excursionByID !== null) {
      content1 = <ExcursionFormPopulated item={excursionByID} />;
    }
    if (error) {
      content1 = <p>{error}</p>;
    }
    if (isLoading) {
      content1 = <p>Loading...</p>;
    }
  }

  if (
    state.whichComponentToShow === "ExcursionItem" &&
    UserStore.user_type === "a"
  ) {
    return (
      <li>
        <Card className="excursion-item">
          <ExcursionDate date={props.date} />
          <div
            className="excursion-item__title"
            onClick={fetchDetailedExcursionByID}
          >
            <h2>{props.title}</h2>
          </div>
        </Card>
      </li>
    );
  } else if (
    state.whichComponentToShow === "ExcursionDetailedItem" &&
    UserStore.user_type === "a"
  ) {
    return (
      <div>
        <section>{content}</section>
      </div>
    );
  } else if (
    state.whichComponentToShow === "ExcursionItem" &&
    UserStore.user_type === "o"
  ) {
    return (
      <li>
        <Card className="excursion-item">
          <ExcursionDate date={props.date} />
          <div
            className="excursion-item__title"
            onClick={fetchDetailedExcursionByID}
          >
            <h2>{props.title}</h2>
          </div>
        </Card>
      </li>
    );
  } else if (
    state.whichComponentToShow === "ExcursionFormPopulated" &&
    UserStore.user_type === "o"
  ) {
    return (
      <div>
        <section>{content1}</section>
      </div>
    );
  }
};

export default ExcursionItem;
