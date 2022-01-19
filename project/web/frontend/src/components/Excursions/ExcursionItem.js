import React, { useState, useEffect } from "react";
import ExcursionDate from "./ExcursionDate";
import "./ExcursionItem.css";
import Card from "../UI/Card";
import UserStore from "../stores/UserStore";
import { useHistory } from "react-router-dom";
import LoadingSpinner from "../UI/LoadingSpinner";
/**
 * @component
 * @param {Object} props
 */
const ExcursionItem = (props) => {
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const history = useHistory();

  /**
   * redirect to the component -> ExcursionDetailedItem for admin view
   * where admin able to view an excursion or reject/approve a pending excursion
   * See {@link ExcursionDetailedItem}
   * @param {Object} excursion
   */
  function detailsForAdmin(excursion) {
    // for better user experience need to display to user if error or still loading
    if (error) {
      excursion = <p>{error}</p>;
    }
    if (isLoading) {
      excursion = <LoadingSpinner />;
    }
    /**
     * redirect to the component -> ExcursionDetailedItem for admin view
     * See {@link ExcursionDetailedItem}
     */
    let path = `/login/excursions/${props.id}`;
    history.push({
      pathname: path,
      state: excursion,
    });
  }

  /**
   * redirect to the component -> ExcursionFormPopulated for organizer view
   * where organizer able to modify an excursion
   * See {@link ExcursionFormPopulated}
   * @param {Object} excursion
   */
  function detailsForOrganizer(excursion) {
    // for better user experience need to display to user if error or still loading
    if (error) {
      excursion = <p>{error}</p>;
    }
    if (isLoading) {
      excursion = <LoadingSpinner />;
    }
    /**
     * redirect to the component -> ExcursionFormPopulated
     * See {@link ExcursionFormPopulated}
     */
    let path = `/login/modify`;
    history.push({
      pathname: path,
      state: excursion,
    });
  }

  /**
   * Download data from http://localhost:9191/excursion/${props.id}
   * download data of a particular excursion
   * @async
   * @function fetchDetailedExcursionByID
   * @return {Promise<string>} The data from the URL.
   */
  async function fetchDetailedExcursionByID() {
    setIsLoading(true);
    // clear previous error
    setError(null);
    try {
      const response = await fetch(
        `http://localhost:9191/excursion/${props.id}`
      );
      /**
       * need to check before parsing the response body
       * signals if the response was successful
       */
      if (!response.ok) {
        throw new Error("Something went wrong!");
      }
      const data = await response.json();
      // if admin will link to ExcursionDetailedItem via detailsForAdmin function
      if (UserStore.user_type === "ROLE_a") {
        detailsForAdmin(data);
      }
      // // if organizer will link to ExcursionFormPpulated via detailsForOrganizer function
      if (UserStore.user_type === "ROLE_o") {
        detailsForOrganizer(data);
      }
    } catch (error) {
      setError(error.message);
    }
    // done loading, no matter if we got successful or an error response
    setIsLoading(false);
  }

  useEffect(() => {
    return () => {};
  }, []);

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
