import React, { useState, useRef } from 'react';

interface Person {
    firstName: string;
    lastName: string;
}

interface Props {
    text: string;
    ok?: boolean;
    i?: number;
    fn?: () => void;
    person: Person;
    handleChange?: (event: React.ChangeEvent<HTMLInputElement>) => void;
}
export const TextField: React.FC<Props> = ({handleChange, person}) => {
    const [count, setCount] = useState<number | null >(5);
    const inputRef = useRef<HTMLInputElement>(null);

    return (
        <div>
            <input onChange={handleChange} ref={inputRef}/>
        </div>
    )
}
