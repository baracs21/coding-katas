package main

import (
	"strings"
	"testing"
)

func Test_createDiamond(t *testing.T) {
	tests := []struct {
		name      string
		letter    string
		want      string
		substring string
	}{
		{
			name:   "create simple diamond for A",
			letter: "A",
			want:   "A",
		},
		{
			name:      "leading space for A must be 1",
			letter:    "B",
			substring: " A\nB",
		},
		{
			name:      "spaces between Cs must be 3",
			letter:    "C",
			substring: "C   C",
		},
		{
			name:      "create upper diamond",
			letter:    "C",
			substring: "  A\n B B\nC   C\n",
		},
		{
			name:   "create diamond for C",
			letter: "C",
			want:   "  A\n B B\nC   C\n B B\n  A\n",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if tt.want != "" {
				if got := CreateDiamond(tt.letter); got != tt.want {
					t.Errorf("createDiamond() = %v, want %v", got, tt.want)
				}
			}
			if tt.substring != "" {
				if got := CreateDiamond(tt.letter); !strings.Contains(got, tt.substring) {
					t.Errorf("createDiamond() = %v, want substring %v", got, tt.substring)
				}
			}
		})
	}
}
