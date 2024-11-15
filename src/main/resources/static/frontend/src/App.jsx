import { useEffect, useState } from 'react';
import axios from 'axios';
import "./App.css";

function App() {
    const [students, setStudents] = useState([]);
    const [newStudent, setNewStudent] = useState({ studentFullName: '', schoolId: '' });
    const [errorMessages, setErrorMessages] = useState({});

    useEffect(() => {
        fetchStudents();
    }, []);

    const fetchStudents = async () => {
        try {
            const response = await axios.get('/api/student/list/all');
            setStudents(response.data);
        } catch (error) {
            console.error("Öğrenciler yüklenirken hata oluştu:", error);
        }
    };

    // Formdaki alanları frontend tarafında doğrulayan fonksiyon
    const validateInputs = () => {
        const errors = {};
        if (newStudent.studentFullName.length < 6 || newStudent.studentFullName.length > 15) {
            errors.studentFullName = "Öğrenci tam adı 6-15 karakter aralığında olmalıdır";
        }
        if (!/^\d{4}$/.test(newStudent.schoolId)) {
            errors.schoolId = "Öğrenci numarası 4 basamaktan oluşmalıdır";
        }
        return errors;
    };

    const addStudent = async () => {
        const errors = validateInputs();
        if (Object.keys(errors).length > 0) {
            setErrorMessages(errors);
            return;
        }

        try {
            const response = await axios.post('/api/student/save', newStudent);
            setStudents([...students, response.data]);
            setNewStudent({ studentFullName: '', schoolId: '' });
            setErrorMessages({});
        } catch (error) {
            console.error("Öğrenci kaydedilirken hata oluştu:", error);
        }
    };

    return (
        <div className="App">
            <h1>Öğrenci Ekleme Sistemi</h1>

            <div>
                <h2>Yeni Öğrenci Ekle</h2>

                {errorMessages.studentFullName && (
                    <p className="error">{errorMessages.studentFullName}</p>
                )}
                <input
                    type="text"
                    placeholder="Öğrenci Tam Adı"
                    value={newStudent.studentFullName}
                    onChange={(e) => setNewStudent({ ...newStudent, studentFullName: e.target.value })}
                    className={errorMessages.studentFullName ? "input-error" : ""}
                />

                {errorMessages.schoolId && (
                    <p className="error">{errorMessages.schoolId}</p>
                )}
                <input
                    type="text"
                    placeholder="Öğrenci Numarası"
                    value={newStudent.schoolId}
                    onChange={(e) => setNewStudent({ ...newStudent, schoolId: e.target.value })}
                    className={errorMessages.schoolId ? "input-error" : ""}
                />

                <button onClick={addStudent}>Ekle</button>
            </div>

            <h2>Öğrenci Listesi</h2>
            {students.length > 0 ? (
                <ul>
                    {students.map((student, index) => (
                        <li key={student.id || index}>{student.studentFullName} - {student.schoolId}</li>
                    ))}
                </ul>
            ) : (
                <p>Henüz kayıtlı öğrenci yok.</p>
            )}
        </div>
    );
}

export default App;
