<?php
session_start();


$username = $_POST['username'];
$password = $_POST['password'];

// Check if the user exists and the password is correct
// Replace this with a proper database query or API call
$isValid = checkCredentials($username, $password);

if ($isValid) {
    // Store user data in the session
// Replace this with actual user data
$_SESSION['user_id'] = 1;
    $_SESSION['username'] = $username;

    // Redirect the user to the dashboard or home page
header('Location: dashboard.php');
    exit;
} else {
    // Handle login failure
$_SESSION['error'] = 'Invalid username or password.';
    header('Location: login.html');
    exit;
}

// Function to check user credentials
function checkCredentials($username, $password) {
    // Replace this with a proper database query or API call
// Return true if the credentials are valid, false otherwise
return $username === 'admin' && $password === 'password';
}
