from otherProjects.name import rearrange_name
import pytest

def test_basic():
	testCase = "İspir, Hakan"
	expectedCase = "Hakan İspir"
	assert rearrange_name(testCase) == expectedCase

def test_null():
	assert rearrange_name("") == ""

def test_doubleName():
	assert rearrange_name("Hopper, Grace M.") == "Grace M. Hopper"

def test_singleName():
	assert rearrange_name("Hopper") == "Hopper"
	# pytest.raises()