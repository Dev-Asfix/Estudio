from flask import Flask, render_template, request, redirect, url_for, jsonify
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

# Configuración de la base de datos
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:admin@localhost:3307/biblioteca'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)

# Modelo
class Libro(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    titulo = db.Column(db.String(255), nullable=False)
    autor = db.Column(db.String(255), nullable=False)
    ano = db.Column(db.Integer, nullable=False)
    genero = db.Column(db.String(100), nullable=False)

# Crear las tablas si no existen
with app.app_context():
    db.create_all()

# Ruta principal: lista los libros
@app.route('/')
def index():
    libros = Libro.query.all()
    return render_template('index.html', libros=libros)

# Ruta para agregar un libro
@app.route('/agregar', methods=['POST'])
def agregar_libro():
    titulo = request.form['titulo']
    autor = request.form['autor']
    ano = request.form['ano']
    genero = request.form['genero']
    
    nuevo_libro = Libro(titulo=titulo, autor=autor, ano=ano, genero=genero)
    db.session.add(nuevo_libro)
    db.session.commit()
    return redirect(url_for('index'))

# Ruta para editar un libro
@app.route('/editar/<int:id>', methods=['POST'])
def editar_libro(id):
    libro = Libro.query.get(id)
    libro.titulo = request.form['titulo']
    libro.autor = request.form['autor']
    libro.ano = request.form['ano']
    libro.genero = request.form['genero']
    db.session.commit()
    return redirect(url_for('index'))

# Ruta para eliminar un libro
@app.route('/eliminar/<int:id>', methods=['POST'])
def eliminar_libro(id):
    libro = Libro.query.get(id)
    db.session.delete(libro)
    db.session.commit()
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
