package main

import "fmt"

func main() {
	fmt.Println(CreateDiamond("Z"))
}

func CreateDiamond(letter string) string {
	var result []string

	start := []byte("A")[0]
	end := []byte(letter)[0]

	leadingSpaces := int(end - start)
	spacesBetween := 1

	for i := start; i <= end; i++ {
		line := ""
		for j := 0; j < leadingSpaces; j++ {
			line += " "
		}
		leadingSpaces--
		line += string(i)
		if i != start {
			for k := 0; k < spacesBetween; k++ {
				line += " "
			}
			spacesBetween += 2
			line += string(i)
		}
		if start != end {
			line += "\n"
		}
		result = append(result, line)
	}

	return buildDiamondString(result)
}

func buildDiamondString(result []string) string {
	diamond := ""
	for i := 0; i < len(result); i++ {
		diamond += result[i]
	}
	for i := len(result) - 2; i >= 0; i-- {
		diamond += result[i]
	}
	return diamond
}
