readme <- "C:/Users/hakan/Downloads/test.txt"

my_data <- scan(file = readme, what = "")
my_data

word_factor = factor(my_data)
summary(word_factor) # gives frequency of words

data2 = c(1,1,1,1,1,2,2,2,2,2,2,2,4,4,4,4,4) 
data2_f = factor(data2) 
summary(data2_f)


# Regex
grep("@.+",  c("test@testing.com" , "not an email", "test2@testing.com"))
grep("@.+",  c("test@testing.com", "not an email", "test2@testing.com"), value=TRUE)
