Public Class Form1
    ' Variables 
    Private currentNumber As String = ""
    Private previousNumber As String = ""
    Private operation As String = ""
    Private result As Double = 0
    Private lastOperation As String = ""
    Private lastResult As Double = 0
    Private operationSequence As New System.Text.StringBuilder() ' Para almacenar la secuencia de operaciones

    ' Evento para el botón de números
    Private Sub NumberButton_Click(sender As Object, e As EventArgs) Handles Btn_0.Click, Btn_1.Click, Btn_2.Click, Btn_3.Click, Btn_4.Click, Btn_5.Click, Btn_6.Click, Btn_7.Click, Btn_8.Click, Btn_9.Click
        currentNumber &= CType(sender, Button).Tag.ToString()
        Btn_caja.Text = currentNumber
    End Sub

    ' Evento para el botón de punto decimal
    Private Sub Btn_punto_Click(sender As Object, e As EventArgs) Handles Btn_punto.Click
        If Not currentNumber.Contains(".") Then
            currentNumber &= "."
            Btn_caja.Text = currentNumber
        End If
    End Sub

    ' Evento para los botones de operaciones
    Private Sub OperationButton_Click(sender As Object, e As EventArgs) Handles Btn_suma.Click, Btn_resta.Click, Btn_multiplicar.Click, Btn_dividir.Click, Btn_porcentaje.Click
        If Not String.IsNullOrEmpty(currentNumber) Then
            If Not String.IsNullOrEmpty(previousNumber) AndAlso Not String.IsNullOrEmpty(operation) Then
                PerformCalculation()
            End If

            previousNumber = currentNumber
            currentNumber = ""
            operation = CType(sender, Button).Tag.ToString()

            ' Actualiza la secuencia de operaciones
            operationSequence.Append(previousNumber).Append(" ").Append(operation).Append(" ")
            Btn_label.Text = operationSequence.ToString()

            Btn_caja.Text = ""
        End If
    End Sub

    ' Realiza el cálculo basado en la operación actual
    Private Sub PerformCalculation()
        Dim num1 As Double
        Dim num2 As Double

        If Double.TryParse(previousNumber, num1) AndAlso Double.TryParse(currentNumber, num2) Then
            Select Case operation
                Case "+"
                    result = num1 + num2
                Case "-"
                    result = num1 - num2
                Case "*"
                    result = num1 * num2
                Case "/"
                    If num2 <> 0 Then
                        result = num1 / num2
                    Else
                        Btn_caja.Text = " No es posible"
                        Btn_label.Text = "Error: División por cero"
                        Exit Sub
                    End If
                Case "%"
                    result = num1 * (num2 / 100)
            End Select

            currentNumber = result.ToString()
            previousNumber = currentNumber

            ' Actualiza la secuencia de operaciones
            operationSequence.Append(currentNumber)
            Btn_caja.Text = result.ToString()
            Btn_label.Text = operationSequence.ToString()
        Else
            Btn_caja.Text = "Error"
            Btn_label.Text = "Error: Entrada inválida"
        End If

        ' Reinicia la operación
        operation = ""
    End Sub

    ' Evento para el botón de igual
    Private Sub Btn_igual_Click(sender As Object, e As EventArgs) Handles Btn_igual.Click
        If Not String.IsNullOrEmpty(currentNumber) AndAlso Not String.IsNullOrEmpty(previousNumber) Then
            PerformCalculation()
            operationSequence.Append(" = ").Append(result.ToString())
            Btn_label.Text = operationSequence.ToString()
            currentNumber = ""
            previousNumber = ""
            operation = ""
        End If
    End Sub

    ' Evento para el botón de clear
    Private Sub Btn_clear_Click(sender As Object, e As EventArgs) Handles Btn_clear.Click
        Btn_label.Text = ""
        Btn_caja.Text = ""
        currentNumber = ""
        previousNumber = ""
        operation = ""
        result = 0
        lastOperation = ""
        lastResult = 0
        operationSequence.Clear()
    End Sub

    ' Evento para el botón de porcentaje
    Private Sub Btn_porcentaje_Click(sender As Object, e As EventArgs) Handles Btn_porcentaje.Click
        If Not String.IsNullOrEmpty(currentNumber) Then
            If Not String.IsNullOrEmpty(previousNumber) AndAlso Not String.IsNullOrEmpty(operation) Then
                PerformCalculation()
            End If

            previousNumber = currentNumber
            currentNumber = ""
            operation = "%"

            ' Actualiza la secuencia de operaciones
            operationSequence.Append(previousNumber).Append(" % ")
            Btn_label.Text = operationSequence.ToString()

            Btn_caja.Text = ""
        End If
    End Sub

    ' Evento para el botón de cerrar
    Private Sub Btn_cerrar_Click(sender As Object, e As EventArgs) Handles Btn_cerrar.Click
        Me.Close()
    End Sub

    ' Evento para el botón de minimizar
    Private Sub Btn_minimizar_Click(sender As Object, e As EventArgs) Handles Btn_minimizar.Click
        Me.WindowState = FormWindowState.Minimized
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        AdjustLabelSize()
    End Sub

    ' Ajusta el tamaño del Label para que no se salga del formulario
    Private Sub AdjustLabelSize()
        Dim maxWidth As Integer = Me.ClientSize.Width - Btn_label.Left * 2
        Btn_label.AutoSize = False
        Btn_label.Width = maxWidth
        Btn_label.MaximumSize = New Size(maxWidth, 0)
        Btn_label.TextAlign = ContentAlignment.MiddleLeft
    End Sub

    ' Evento para redimensionar el formulario
    Private Sub Form1_Resize(sender As Object, e As EventArgs) Handles MyBase.Resize
        AdjustLabelSize()
    End Sub

End Class
