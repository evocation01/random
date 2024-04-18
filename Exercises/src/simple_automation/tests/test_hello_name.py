import pytest

from simple_automation import hello_name


def test_basic():
    testCase = "İspir, Hakan"
    expectedCase = "Hakan İspir"
    assert hello_name(testCase) == expectedCase


def test_null():
    assert hello_name("") == ""


def test_doubleName():
    assert hello_name("Hopper, Grace M.") == "Grace M. Hopper"


def test_singleName():
    assert hello_name("Hopper") == "Hopper"
    # pytest.raises()
