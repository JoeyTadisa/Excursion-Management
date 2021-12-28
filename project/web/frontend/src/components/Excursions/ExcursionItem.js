import React, { useState, useEffect } from "react";
import ExcursionDate from "./ExcursionDate";
import "./ExcursionItem.css";
import Card from "../UI/Card";
import UserStore from "../stores/UserStore";
import { useHistory } from "react-router-dom";
import LoadingSpinner from "../UI/LoadingSpinner";

const ExcursionItem = (props) => {
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const history = useHistory();

  function detailsForAdmin(excursion) {
    // for better user experience need to display to user if error or still loading
    if (error) {
      excursion = <p>{error}</p>;
    }
    if (isLoading) {
      excursion = <LoadingSpinner />;
    }
    let path = `/login/excursions/${props.id}`;
    history.push({
      pathname: path,
      state: excursion,
    });
  }

  function detailsForOrganizer(excursion) {
    // for better user experience need to display to user if error or still loading
    if (error) {
      excursion = <p>{error}</p>;
    }
    if (isLoading) {
      excursion = <LoadingSpinner />;
    }
    let path = `/login/modify`;
    history.push({
      pathname: path,
      state: excursion,
    });
  }

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
      // if admin will link to ExcursionDetailedItem via detailsForAdmin function
      if (UserStore.user_type === "a") {
        detailsForAdmin(data);
      }
      // // if organizer will link to ExcursionFormPpulated via detailsForOrganizer function
      if (UserStore.user_type === "o") {
        detailsForOrganizer(data);
      }
    } catch (error) {
      setError(error.message);
    }
    // done loading, no matter if we got successful or an error response
    setIsLoading(false);
  }

  useEffect(() => {}, []);

  return (
    <li>
      <Card className="excursion-item">
        <ExcursionDate date={props.date} />

        <div className="excursion-item__title">
          <a
            className="excursion-item-link"
            onClick={fetchDetailedExcursionByID}
          >
            {props.title}
          </a>
        </div>
      </Card>
    </li>
  );
};

export default ExcursionItem;
