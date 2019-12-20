﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using TechElevator.Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;
using Exercises.Tests;

namespace TechElevator.Classes.Tests
{
    [TestClass()]
    public class CalculatorTests
    {
        private Type type;
        private Calculator calculator;

        [TestInitialize]
        public void Before()
        {
            type = typeof(Calculator);
            calculator = (Calculator)Activator.CreateInstance(type);
        }

        [TestMethod]
        public void Calculator_ResultProperty()
        {
            PropertyInfo prop = type.GetProperty("Result");
            PropertyValidator.ValidateReadOnly(prop, "Result", typeof(int));
        }

        [TestMethod]
        public void Calculator_AddMethod()
        {
            MethodInfo mi = type.GetMethod("Add");
            Assert.IsNotNull(mi, "Calculator class needs the Add method.");
            Assert.AreEqual(typeof(int), mi.ReturnType, "Add(int addend) method needs to return type: int");
            Assert.AreEqual(1, mi.GetParameters().Length, "Add(int addend) should have 1 parameter");
        }

        [TestMethod]
        public void Calculator_SubtractMethod()
        {
            MethodInfo mi = type.GetMethod("Subtract");
            Assert.IsNotNull(mi, "Calculator class needs the Subtract method.");
            Assert.AreEqual(typeof(int), mi.ReturnType, "Subtract(int subtrahend) method needs to return type: int");
            Assert.AreEqual(1, mi.GetParameters().Length, "Subtract(int subtrahend) should have 1 parameter");
        }

        [TestMethod]
        public void Calculator_MultiplyMethod()
        {
            MethodInfo mi = type.GetMethod("Multiply");
            Assert.IsNotNull(mi, "Calculator class needs the Multiply method.");
            Assert.AreEqual(typeof(int), mi.ReturnType, "Multiply(int multiplier) method needs to return type: int");
            Assert.AreEqual(1, mi.GetParameters().Length, "Multiply(int multiplier) should have 1 parameter");
        }

        [TestMethod]
        public void Calculator_PowerMethod()
        {
            MethodInfo mi = type.GetMethod("Power");
            Assert.IsNotNull(mi, "Calculator class needs the Power method.");
            Assert.AreEqual(typeof(int), mi.ReturnType, "Power(int exponent) method needs to return type: int");
            Assert.AreEqual(1, mi.GetParameters().Length, "Power(int exponent) should have 1 parameter");
        }

        [TestMethod]
        public void Calculator_ResetMethod()
        {
            MethodInfo mi = type.GetMethod("Reset");
            Assert.IsNotNull(mi, "Calculator class needs the Reset method.");
            Assert.AreEqual(typeof(void), mi.ReturnType, "Reset() method needs to return type: void");
            Assert.AreEqual(0, mi.GetParameters().Length, "Reset() should have no parameters");
        }

        [TestMethod()]
        public void Calculator_ConstructorTest()
        {
            Assert.AreEqual(0, type.GetProperty("Result").GetValue(calculator), "New Calculator constructors should set the result to 0");
        }

        [TestMethod]
        public void Calculator_ResetTest()
        {
            type.GetProperty("Result").SetValue(calculator, 10);
            type.GetMethod("Reset").Invoke(calculator, null);

            Assert.AreEqual(0, type.GetProperty("Result").GetValue(calculator), "Reset() should set result to 0");
        }

        [TestMethod()]
        public void Calculator_AddTest()
        {
            MethodInfo mi = type.GetMethod("Add");

            type.GetProperty("Result").SetValue(calculator, 10);

            Assert.AreEqual(20, mi.Invoke(calculator, new object[] { 10 }), "Add() should return the new value for result.");
            Assert.AreEqual(20, type.GetProperty("Result").GetValue(calculator), "Add() should update the value for result by adding addend.");
        }

        [TestMethod]
        public void Calculator_MultipleTest()
        {
            MethodInfo mi = type.GetMethod("Multiply");

            type.GetProperty("Result").SetValue(calculator, 10);

            Assert.AreEqual(40, mi.Invoke(calculator, new object[] { 4 }), "Multiply() should return the new value for result.");
            Assert.AreEqual(40, type.GetProperty("Result").GetValue(calculator), "Multiply() should update the value for result by multiplying by multiplier.");
        }

        [TestMethod()]
        public void Calculator_SubtractTest()
        {
            MethodInfo mi = type.GetMethod("Subtract");

            type.GetProperty("Result").SetValue(calculator, 10);

            Assert.AreEqual(6, mi.Invoke(calculator, new object[] { 4 }), "Subtract() should return the new value for result.");
            Assert.AreEqual(6, type.GetProperty("Result").GetValue(calculator), "Subtract() should update the value for result by subtracting by subtrahend.");
        }

        [TestMethod()]
        public void Calculator_PowerTest()
        {
            MethodInfo mi = type.GetMethod("Power");

            type.GetProperty("Result").SetValue(calculator, 5);

            Assert.AreEqual(25, mi.Invoke(calculator, new object[] { 2 }), "Power() should return the new value for result.");
            Assert.AreEqual(25, type.GetProperty("Result").GetValue(calculator), "Power() should update the value for raising result to the exponent.");
        }
    }
}