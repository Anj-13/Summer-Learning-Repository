import express from 'express';

const app = express();

app.get('/', (req, res) => {
    res.send('Test docker');
});

const port = process.env.PORT || 3000;
app.listen(port, () =>{
    console.log(`Running on port http://localhost:${port}`);
});