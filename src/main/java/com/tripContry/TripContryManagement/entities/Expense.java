package com.tripContry.TripContryManagement.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    private String id;
    private String title;
    private Double amount;

    @Column(name = "paid_by")
    private String paidBy;
    private LocalDateTime date;
    private String category;

    @ElementCollection
    @CollectionTable(name = "expense_split_among", joinColumns = @JoinColumn(name = "expense_id"))
    @Column(name = "member_id")
    private List<String> splitAmongs;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    @JsonIgnore
    private Trip trip;
}
