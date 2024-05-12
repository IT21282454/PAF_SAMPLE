import React, { useEffect, useState } from "react";
import "./AdminRetrieve.css";
import NavigationBar from "../Components/NavigationBar";
import axios from "axios";
import Swal from "sweetalert2";
import toast from "react-hot-toast";

function AdminRetrieve() {
    const [workouts, setWorkouts] = useState([]);

    // Get all workouts
    useEffect(() => {
        const fetchItem = async () => {
            const result = await axios.get("http://localhost:8080/workouts");
            setWorkouts(result.data);
            console.log(result.data);
        };

        fetchItem();
    }, []);

    // Update Workout
    const handleEdit = (id) => {
        alert(`Update : ${id}`)
    }

    // Delete Workout
    const handleDelete = (id) => {
        try {
            Swal.fire({
                title: "Are you sure?",
                text: "You won't be able to revert this!",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes, delete it!",
            }).then(async (result) => {
                if (result.isConfirmed) {
                    Swal.fire({
                        title: "Deleted!",
                        text: "Workout has been deleted.",
                        icon: "success",
                    });

                    await axios.delete(`http://localhost:8080/workouts/${id}`);

                    setWorkouts(
                        workouts.filter((item) => {
                            if (item.id === id) {
                                return false;
                            } else {
                                return true;
                            }
                        })
                    );

                    toast.success("Workout Deleted!")
                }
            });
        } catch (err) {
            console.log(err).Swal.fire({
                title: "Error",
                text: "Failed to delete item.",
                icon: "error",
            });
        }
    };

    return (
        <div>
            <NavigationBar />
            <div className="dashboard-top">
                <h1>Admin Dashboard</h1>
                <div>
                    <button type="button" className="btn btn-primary">
                        Add Workout
                    </button>
                </div>
            </div>

            <div id="table-container">
                <table className="table table-borded">
                    <thead className="table-info">
                        <tr>
                            <th scope="col">Index</th>
                            <th scope="col">Type</th>
                            <th scope="col">Description</th>
                            <th scope="col">Type</th>
                            <th scope="col">Workout</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        {workouts.map((item, index) => {
                            return (
                                <tr key={index}>
                                    <td>{index + 1}</td>
                                    <td>{item.catergory}</td>
                                    <td>{item.description}</td>
                                    <td>{item.type}</td>
                                    <td>{item.workout}</td>
                                    <td>
                                        <div className="action-btns">
                                            <button
                                                className="btn btn-success btn-sm"
                                                onClick={() => handleEdit(item.id)}
                                            >
                                                Edit
                                            </button>
                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    handleDelete(item.id)
                                                }
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            );
                        })}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default AdminRetrieve;
